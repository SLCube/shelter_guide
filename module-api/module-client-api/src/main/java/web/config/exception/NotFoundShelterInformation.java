package web.config.exception;


import static web.config.exception.CustomErrorCode.NOT_FOUND_SHELTER_INFORMATION;

public class NotFoundShelterInformation extends CustomException {
    public NotFoundShelterInformation() {
        super(NOT_FOUND_SHELTER_INFORMATION);
    }
}
