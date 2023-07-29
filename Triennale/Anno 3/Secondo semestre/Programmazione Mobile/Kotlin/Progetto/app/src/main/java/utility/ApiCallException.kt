package utility

class ApiCallException(responseCode: Int) : Exception("API call with error: $responseCode")