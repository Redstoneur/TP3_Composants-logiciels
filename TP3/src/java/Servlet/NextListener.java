
import Servlet.CatalogBrowserBean;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.event.*;


@ManagedBean(name="nextListen")
@SessionScoped
public class NextListener implements Serializable, ActionListener {

    private static final long serialVersionUID = -7752358388239085979L;
    
    private CatalogBrowserBean catalogBrowserBean;


    @Override
    public void processAction( ActionEvent event) throws AbortProcessingException {
        catalogBrowserBean.setIndex( catalogBrowserBean.getIndex() + 1);
    }
    
}