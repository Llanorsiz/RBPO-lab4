package kurban.softwareProducts.developmentTask.exception;

import kurban.softwareProducts.common.exception.base.NotFoundException;

public class DevelopmentTaskNotFoundException extends NotFoundException {
    public DevelopmentTaskNotFoundException() {
        super("Задача на разработку не найдена");
    }
}
