package org.petshop.model;

import java.io.Serializable;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

/**
 * An implementation of SelectableDataModel using a list as data
 */
public class PrimeDataModel<T> extends ListDataModel implements SelectableDataModel<T>, Serializable {
            
    public PrimeDataModel() {}
    
    public PrimeDataModel(Object data) {
        setWrappedData(data);
    }
    
    public String getRowKey(T object) {
        throw new UnsupportedOperationException("Must be implemented");
    }
    
    public T getRowData(String rowKey) {
        throw new UnsupportedOperationException("Must be implemented");
    }
}