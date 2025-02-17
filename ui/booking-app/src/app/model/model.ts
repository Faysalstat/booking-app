export class UserRegistration {
    id!: number;
    profileImage!: string;
    firstName!: string;
    lastName!: string;
    phoneNumber!: number;
    email!: string;
    dateOfBirth!: string; // ISO-8601 formatted date string (e.g., 'YYYY-MM-DD')
    gender: string = "Male";
    age!: number;
    address!: string;
    country!: string;
    state!: string;
    creditScore!: number;
    panCardNumber!: string;
    userRole: string = "CUSTOMER";
    password!: string;
  }
  export class UserDetails {
    userName!: string;
    password!: string;
    userType: string ="USER";
    driverName!: string;
    phone!: string;
    ambulanceNumber!: string;
    hospitalName!: string;
    location!: string;
  }

  export enum UserType{
    USER,
    HOSPITAL,
    AMBULANCE
  }

  export class BookingDTO {
    id!: number;
    userId!: number;
    ambulanceDriverId!: number;
    hospitalId!: number;
    pickupLocation!: string;
    status!: string;
    hospital!:Hospital;
  }
  export class Hospital{
    id!: number;
    location!:string;
  }

