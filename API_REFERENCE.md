# API Reference Guide

## Base URL
```
http://localhost:8080/api/hotels
```

---

## 🏨 Rooms Endpoints

### List All Rooms
```
GET /api/hotels/rooms
```

**Description:** Retrieve a list of all hotel rooms with their current status.

**Response:** `200 OK`
```json
[
  {
    "id": 1,
    "number": "101",
    "roomType": "SINGLE",
    "status": "AVAILABLE",
    "baseRate": 100.0
  },
  {
    "id": 2,
    "number": "102",
    "roomType": "DOUBLE",
    "status": "AVAILABLE",
    "baseRate": 150.0
  },
  {
    "id": 3,
    "number": "103",
    "roomType": "SUITE",
    "status": "RESERVED",
    "baseRate": 250.0
  }
]
```

**Status Codes:**
- `200 OK` - Rooms retrieved successfully
- `500 Internal Server Error` - Server error

---

## 📅 Reservations Endpoints

### Create Reservation
```
POST /api/hotels/reservations
Content-Type: application/json
```

**Description:** Create a new reservation for a guest.

**Request Body:**
```json
{
  "roomId": 1,
  "guestId": 1,
  "checkInDate": "2026-04-15",
  "checkOutDate": "2026-04-20",
  "services": [
    {
      "id": 1,
      "serviceType": "BREAKFAST",
      "description": "Continental breakfast included",
      "cost": 15.0
    },
    {
      "id": 2,
      "serviceType": "SPA",
      "description": "Spa package",
      "cost": 50.0
    }
  ]
}
```

**Response:** `201 Created`
```json
{
  "reservationId": 101,
  "status": "CREATED",
  "estimatedTotal": 615.0,
  "message": "Reservation created successfully"
}
```

**Calculation Example:**
- Base Rate (5 nights): 100.0 × 5 = 500.0
- Services: 15.0 + 50.0 = 65.0
- Subtotal: 500.0 + 65.0 = 565.0
- Taxes (19%): 565.0 × 0.19 = 107.35
- **Total: 615.0** (rounded)

**Status Codes:**
- `201 Created` - Reservation created successfully
- `400 Bad Request` - Invalid request (room not available, missing fields)
- `404 Not Found` - Room or guest not found
- `500 Internal Server Error` - Server error

**Error Response Examples:**

Room not available:
```json
{
  "timestamp": "2026-04-10T15:50:30.123456",
  "status": 400,
  "error": "Bad Request",
  "message": "The room is not available for reservation."
}
```

Room not found:
```json
{
  "timestamp": "2026-04-10T15:50:30.123456",
  "status": 404,
  "error": "Not Found",
  "message": "Room not found with id: 999"
}
```

---

## 📊 Data Models

### Room Object
```json
{
  "id": 1,
  "number": "101",
  "roomType": "SINGLE",
  "status": "AVAILABLE",
  "baseRate": 100.0
}
```

**Fields:**
- `id` (Long): Unique identifier
- `number` (String): Room number (e.g., "101", "202")
- `roomType` (String): Type of room (SINGLE, DOUBLE, SUITE)
- `status` (String): Current status (AVAILABLE, RESERVED, OCCUPIED)
- `baseRate` (Double): Nightly rate in currency units

### Reservation Object
```json
{
  "id": 101,
  "roomId": 1,
  "guestId": 1,
  "checkInDate": "2026-04-15",
  "checkOutDate": "2026-04-20",
  "status": "CREATED",
  "services": [...]
}
```

**Fields:**
- `id` (Long): Unique reservation identifier
- `roomId` (Long): ID of reserved room
- `guestId` (Long): ID of guest
- `checkInDate` (Date): Check-in date (YYYY-MM-DD)
- `checkOutDate` (Date): Check-out date (YYYY-MM-DD)
- `status` (String): Reservation status
- `services` (Array): List of additional services

### AdditionalService Object
```json
{
  "id": 1,
  "serviceType": "BREAKFAST",
  "description": "Continental breakfast included",
  "cost": 15.0
}
```

**Fields:**
- `id` (Long): Service identifier
- `serviceType` (String): Type of service
- `description` (String): Service description
- `cost` (Double): Service cost per night or flat fee

### Invoice Object
```json
{
  "id": 1,
  "reservationId": 101,
  "subtotal": 565.0,
  "taxes": 107.35,
  "total": 615.0,
  "issuedAt": "2026-04-10T15:45:30"
}
```

**Fields:**
- `id` (Long): Invoice identifier
- `reservationId` (Long): Associated reservation ID
- `subtotal` (Double): Sum before taxes
- `taxes` (Double): Calculated tax amount (19% of subtotal)
- `total` (Double): Final amount due
- `issuedAt` (LocalDateTime): Invoice generation timestamp

### DigitalKey Object
```json
{
  "id": 1,
  "reservationId": 101,
  "accessCode": "550e8400-e29b-41d4-a716-446655440000",
  "activationTime": "2026-04-15T16:00:00",
  "expirationTime": "2026-04-20T10:00:00",
  "active": true
}
```

**Fields:**
- `id` (Long): Key identifier
- `reservationId` (Long): Associated reservation
- `accessCode` (String): UUID access code
- `activationTime` (DateTime): When key becomes active (check-in time)
- `expirationTime` (DateTime): When key expires (checkout + 2 days)
- `active` (Boolean): Whether key is currently active

---

## 📋 Enums

### RoomStatus
```
AVAILABLE   - Room is available for booking
RESERVED    - Room is reserved but guest hasn't checked in
OCCUPIED    - Guest is currently in room
```

### ReservationStatus
```
CREATED     - Reservation just created
CONFIRMED   - Reservation confirmed
CHECKED_IN  - Guest has checked in
CHECKED_OUT - Guest has checked out
CANCELED    - Reservation was canceled
```

### RoomType
```
SINGLE      - Single occupancy room
DOUBLE      - Double occupancy room
SUITE       - Luxury suite room
```

### ServiceType
```
SPA         - Spa and wellness services
BREAKFAST   - Breakfast service
TRANSFER    - Airport/ground transportation
```

### Season
```
HIGH        - High season (20% rate multiplier)
LOW         - Low season (standard rate)
```

---

## 🔢 Billing Rules

### Tax Calculation
```
Taxes = Subtotal × 0.19 (19% VAT)
```

### Total Calculation
```
Subtotal = (Nightly Rate × Number of Nights) + Sum of Services
Taxes = Subtotal × 0.19
Total = Subtotal + Taxes
```

### Example Calculation
```
Room: DOUBLE @ 150.0/night
Nights: 3
Services: Breakfast (15.0) × 3 days = 45.0
Additional: Transfer (50.0)

Calculation:
  Room cost: 150.0 × 3 = 450.0
  Services: 45.0 + 50.0 = 95.0
  Subtotal: 450.0 + 95.0 = 545.0
  Taxes: 545.0 × 0.19 = 103.55
  Total: 545.0 + 103.55 = 648.55
```

---

## ⏰ Date Format

All dates use ISO 8601 format:
```
YYYY-MM-DD        - Date (e.g., 2026-04-15)
YYYY-MM-DDTHH:mm:ss - DateTime (e.g., 2026-04-15T16:00:00)
```

---

## 🚨 Error Handling

### Error Response Format
```json
{
  "timestamp": "2026-04-10T15:50:30.123456",
  "status": 400,
  "error": "Bad Request",
  "message": "The room is not available for reservation."
}
```

### Common Error Codes

| Code | Error | Meaning |
|------|-------|---------|
| 400 | Bad Request | Invalid input or room not available |
| 404 | Not Found | Resource doesn't exist |
| 500 | Internal Server Error | Server processing error |

---

## 📝 Request Examples

### Create Reservation with Multiple Services
```bash
curl -X POST http://localhost:8080/api/hotels/reservations \
  -H "Content-Type: application/json" \
  -d '{
    "roomId": 2,
    "guestId": 5,
    "checkInDate": "2026-05-01",
    "checkOutDate": "2026-05-07",
    "services": [
      {"id": 1, "serviceType": "BREAKFAST", "description": "Daily breakfast", "cost": 20.0},
      {"id": 2, "serviceType": "SPA", "description": "Spa day package", "cost": 100.0},
      {"id": 3, "serviceType": "TRANSFER", "description": "Airport transfer", "cost": 50.0}
    ]
  }'
```

### Get All Rooms
```bash
curl http://localhost:8080/api/hotels/rooms
```

---

## 💡 Best Practices

1. **Dates:** Always use YYYY-MM-DD format for check-in/check-out
2. **Services:** Include all services during reservation creation
3. **Validation:** Ensure check-out date is after check-in date
4. **Rates:** Contact system to verify current room rates
5. **Error Handling:** Check response status and error message field
6. **Idempotency:** Don't retry requests without verifying if resource was created

---

## 🔧 Testing with cURL

### Test Room Listing
```bash
curl -i http://localhost:8080/api/hotels/rooms
```

### Test Reservation Creation
```bash
curl -i -X POST http://localhost:8080/api/hotels/reservations \
  -H "Content-Type: application/json" \
  -d '{"roomId":1,"guestId":1,"checkInDate":"2026-04-15","checkOutDate":"2026-04-20","services":[]}'
```

---

**Last Updated:** April 10, 2026

