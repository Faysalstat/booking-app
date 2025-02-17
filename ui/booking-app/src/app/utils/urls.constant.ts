const BASE_URL = "http://localhost:8000/api";

// Security Service 
export const AuthenticationUrls = {
  REGISTER_USER : BASE_URL + "/auth/register",
  LOGIN : BASE_URL + "/auth/token",
  CHECK_IS_LOGGEDIN: BASE_URL + "/auth/validate"
}

export const CityUrls = {
  CLOSEST_CITIES : BASE_URL + "/booking-service/city/closest-list",
  CITY_LIST : BASE_URL + "/booking-service/city/getall"
}

export const AMBULANCE_URL = {
  CLOSEST_AMBULANCE : BASE_URL + "/booking-service/ambulance/nearest",
  UPDATE_AMBULANCE_BOOKING_STATUS : BASE_URL + "/booking-service/ambulance/update",
  
  
}
export const HOSPITAL_URL = {
  CLOSEST_AMBULANCE : BASE_URL + "/booking-service/hospital/nearest"
}
export const BOOKING_URL = {
  BOOK_NOW : BASE_URL + "/booking-service/booking",
  GET_ALL_AMBULANCE_BOOKING : BASE_URL + "/booking-service/booking/ambulance/get-all",
  GET_ALL_BOOKING : BASE_URL + "/booking-service/booking/hospital/get-all",
}