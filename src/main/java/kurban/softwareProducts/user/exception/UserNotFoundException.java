package kurban.softwareProducts.user.exception;

import kurban.softwareProducts.common.exception.base.NotFoundException;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException() {
        super("Пользователь не найден");
    }
}
