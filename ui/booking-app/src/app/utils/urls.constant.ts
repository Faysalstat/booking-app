const BASE_URL = "http://localhost:8000";

// Security Service 
export const AuthenticationUrls = {
  REGISTER_USER : BASE_URL + "/auth/register",
  LOGIN : BASE_URL + "/auth/token",
  CHECK_IS_LOGGEDIN: BASE_URL + "/auth/validate"
}

export const CityUrls = {
  CLOSEST_CITIES : BASE_URL + "/api/booking-service/city/closest-list",
  CITY_LIST : BASE_URL + "/api/booking-service/city/getall"
}