package com.spring_boot_annotations.Controller;

import com.spring_boot_annotations.Components.PrototypeBean;
import com.spring_boot_annotations.Components.RequestBean;
import com.spring_boot_annotations.Components.SingletonBean;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/beans")
public class BeanScopeController {

    // Injecting a singleton bean, which is shared across the entire application.
    // This bean is created once when the container initializes.
    private final SingletonBean singletonBean;

    // Injecting a request-scoped bean, which is unique to every HTTP request.
    // A new instance of this bean is created for each incoming HTTP request.
    private final RequestBean requestBean;

    // Using ObjectProvider to dynamically fetch a prototype bean instance.
    // Prototype beans are not managed by the Spring container after creation.
    // A new instance of the bean is created every time we explicitly request it.
    private final ObjectProvider<PrototypeBean> prototypeBeanProvider;

    // Constructor injection for the beans
    public BeanScopeController(SingletonBean singletonBean, ObjectProvider<PrototypeBean> prototypeBeanProvider,@Lazy RequestBean requestBean) {
        this.singletonBean = singletonBean;
        this.prototypeBeanProvider = prototypeBeanProvider;
        this.requestBean = requestBean;
    }

    // Endpoint to retrieve the singleton bean's instance ID.
    // The same instance is shared across the application, so the instance ID will remain constant.
    @GetMapping("/singleton")
    public String getSingletonInstance() {
        return "Singleton Bean Instance ID: " + singletonBean.getInstanceId();
    }

    // Endpoint to retrieve the prototype bean's instance ID.
    // A new instance is created every time this endpoint is called, because we explicitly request it from ObjectProvider.
    @GetMapping("/prototype")
    public String getPrototypeInstance() {
        PrototypeBean prototypeBean = prototypeBeanProvider.getObject(); // Fetching a new instance
        return "Prototype Bean Instance ID: " + prototypeBean.getInstanceId();
    }

    // Endpoint to retrieve the request bean's instance ID.
    // A new instance of this bean is created for every HTTP request, so the ID will change with each call.
    @GetMapping("/request")
    public String getRequestInstance() {
        return "Request Bean Instance ID: " + requestBean.getInstanceId();
    }
}
