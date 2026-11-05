package kurban.softwareProducts.softwareProduct.exception;

import kurban.softwareProducts.common.exception.base.NotFoundException;

public class SoftwareProductNotFoundException extends NotFoundException {
    public SoftwareProductNotFoundException() {
        super("Программный продукт не найден");
    }
}
