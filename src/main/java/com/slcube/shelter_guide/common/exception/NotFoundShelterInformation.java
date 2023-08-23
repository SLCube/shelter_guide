package com.slcube.shelter_guide.common.exception;

import static com.slcube.shelter_guide.common.exception.CustomErrorCode.*;

public class NotFoundShelterInformation extends CustomException {
    public NotFoundShelterInformation() {
        super(NOT_FOUND_SHELTER_INFORMATION);
    }
}
