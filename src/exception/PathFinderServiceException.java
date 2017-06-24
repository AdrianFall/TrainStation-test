package exception;

/**
 * Created by Adrian on 24/06/2017.
 */
public class PathFinderServiceException extends ServiceException {

    public enum ErrorCode {
        NoRouteConnectionException("No connection from route to target is possible.");

        private String value;

        ErrorCode(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public PathFinderServiceException(ErrorCode errorCode, String errorMessage) {
        super(errorCode.getValue(), errorMessage);
    }
}
