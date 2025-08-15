package com.example.litthu_eyelash_app.presentation.mockdata


// Data Classes
data class Appointment(
    val id: Int,
    val name: String,
    val time: String,
    val doctor: String,
    val status: AppointmentStatus,
    val type: AppointmentType,
    val bookedTime: String,
    val phoneNumber: String,
)


enum class AppointmentStatus(val status: String) {
    DEPOSITED("Deposited"),
    NO_DEPOSIT("No Deposit")
}

enum class AppointmentType(val type: String) {
    NEW("New"),
    TOUCH_UP("Touch-up")
}


data class AppointmentSection(
    val date: String,
    val appointments: List<Appointment>
)

val MOCK_APPOINTMENT_SECTION = listOf(
    AppointmentSection(
        date = "Yesterday, July 29",
        appointments = listOf(
            Appointment(
                id = 3,
                name = "David Lee",
                time = "9:00 AM",
                doctor = "Dr. Emma Wilson",
                status = AppointmentStatus.DEPOSITED,
                type = AppointmentType.NEW,
                bookedTime = "Booked 3 days ago",
                phoneNumber = "0903261998",
            ),
            Appointment(
                id = 4,
                name = "Emily Taylor",
                time = "3:00 PM",
                doctor = "Dr. James Garcia",
                status = AppointmentStatus.NO_DEPOSIT,
                type = AppointmentType.TOUCH_UP,
                bookedTime = "Booked today",
                phoneNumber = "0903261998",
            )
        )
    ),
    AppointmentSection(
        date = "Today, July 30",
        appointments = listOf(
            Appointment(
                id = 1,
                name = "John Smith",
                time = "10:00 AM",
                doctor = "Dr. Emma Wilson",
                status = AppointmentStatus.DEPOSITED,
                type = AppointmentType.NEW,
                bookedTime = "Booked 2 days ago",
                phoneNumber = "0903261998",
            ),
            Appointment(
                id = 2,
                name = "Sarah Johnson",
                time = "1:30 PM",
                doctor = "Dr. Michael Brown",
                status = AppointmentStatus.NO_DEPOSIT,
                type = AppointmentType.TOUCH_UP,
                bookedTime = "Booked yesterday",
                phoneNumber = "0903261998",

                )
        )
    ),
    AppointmentSection(
        date = "Tomorrow, July 31",
        appointments = listOf(
            Appointment(
                id = 3,
                name = "David Lee",
                time = "9:00 AM",
                doctor = "Dr. Emma Wilson",
                status = AppointmentStatus.DEPOSITED,
                type = AppointmentType.TOUCH_UP,
                bookedTime = "Booked 3 days ago",
                phoneNumber = "0903261998",
            ),
            Appointment(
                id = 4,
                name = "Emily Taylor",
                time = "3:00 PM",
                doctor = "Dr. James Garcia",
                status = AppointmentStatus.NO_DEPOSIT,
                type = AppointmentType.NEW,
                bookedTime = "Booked today",
                phoneNumber = "0903261998",
            )
        )
    )
)