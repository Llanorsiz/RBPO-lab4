package kurban.softwareProducts.release.exception;

import kurban.softwareProducts.common.exception.base.NotFoundException;

public class ReleaseNotFoundException extends NotFoundException {
    public ReleaseNotFoundException() {
        super("Релиз не найден");
    }
}
