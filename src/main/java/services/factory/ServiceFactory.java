package services.factory;

import services.Service;

public interface ServiceFactory {
    <Type extends Service> Type getService(Class<Type> key);
}
