package org.example;

public class ServiceProvider {
    private final CarService carService=new CarServiceImpl();
    private static ServiceProvider serviceProvider;
    private ServiceProvider(){}
    public static ServiceProvider getInstance(){
        if(serviceProvider==null){
            synchronized (ServiceProvider.class){
                if(serviceProvider==null){
                    serviceProvider= new ServiceProvider();
                }
            }
        }
        return serviceProvider;
    }

    public CarService getCarService() {
        return carService;
    }
}
