package com.slcube.shelter_guide.web.config.exception;


import static com.slcube.shelter_guide.web.config.exception.CustomErrorCode.NOT_FOUND_SHELTER_INFORMATION;

public class NotFoundShelterInformation extends CustomException {
    public NotFoundShelterInformation() {
        super(NOT_FOUND_SHELTER_INFORMATION);
    }
}
