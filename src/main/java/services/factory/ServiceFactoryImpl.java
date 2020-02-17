package services.factory;

import services.*;

import java.util.HashMap;
import java.util.Map;

public class ServiceFactoryImpl implements ServiceFactory {

    private static final Map<Class<? extends Service> , Service > SERVICES = new HashMap<>();

    static {
        SERVICES.put(FilmService.class, new FilmServiceImpl());
        SERVICES.put(DirectorService.class, new DirectorServiceImpl());
    }


    @Override
    public <Type extends Service> Type getService(Class<Type> key) {
        return (Type) SERVICES.get(key);
    }
}
