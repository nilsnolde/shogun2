/**
 *
 */
package de.terrestris.shogun2.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import de.terrestris.shogun2.dao.WpsParameterDao;
import de.terrestris.shogun2.model.wps.WpsParameter;
import de.terrestris.shogun2.service.WpsParameterService;

/**
 * @author Nils Bühner
 */
@Controller
@RequestMapping("/wpsparameters")
public class WpsParameterController<E extends WpsParameter, D extends WpsParameterDao<E>, S extends WpsParameterService<E, D>>
    extends AbstractWebController<E, D, S> {

    /**
     * Default constructor, which calls the type-constructor
     */
    @SuppressWarnings("unchecked")
    public WpsParameterController() {
        this((Class<E>) WpsParameter.class);
    }

    /**
     * Constructor that sets the concrete entity class for the controller.
     * Subclasses MUST call this constructor.
     */
    protected WpsParameterController(Class<E> entityClass) {
        super(entityClass);
    }

    /**
     * We have to use {@link Qualifier} to define the correct service here.
     * Otherwise, spring can not decide which service has to be autowired here
     * as there are multiple candidates.
     */
    @Override
    @Autowired
    @Qualifier("wpsParameterService")
    public void setService(S service) {
        this.service = service;
    }

}
