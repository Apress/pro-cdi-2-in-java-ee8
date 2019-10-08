package org.omnifaces.procdi.chapter2.servicelocator;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.spi.CDI;
import javax.faces.annotation.FacesConfig;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.naming.InitialContext;

@Named
@RequestScoped
@FacesConfig
public class IndexBacking {
 
    public String onLoad() throws Exception {
        
        SomeService someServiceEJB =
                (SomeService) new InitialContext().lookup("java:module/SomeService");
        
        SomeService someServiceJSF =
                FacesContext.getCurrentInstance()
                                      .getApplication()
                                      .evaluateExpressionGet(
                                              FacesContext.getCurrentInstance(),
                                              "#{someService}",
                                             SomeService.class);
        SomeService someServiceCDI =
                CDI.current().select(SomeService.class).get();
        
        return null;
    }
}
