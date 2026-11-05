package kurban.softwareProducts.releaseCheck.exception;

import kurban.softwareProducts.common.exception.base.NotFoundException;

public class ReleaseCheckNotFoundException extends NotFoundException {
    public ReleaseCheckNotFoundException() {
        super("Проверка релиза не найдена");
    }
}
