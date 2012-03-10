package org.petshop.model;

import java.util.List;

import org.petshop.dominio.Cliente;

public class ClienteDataModel extends PrimeDataModel<Cliente> {

    public ClienteDataModel() {
    }

    public ClienteDataModel(Object data) {
        super(data);
    }
    
    @Override
    public Cliente getRowData(String rowKey) {
        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data
        
        List<Cliente> clientes = (List<Cliente>) getWrappedData();
        
        for(Cliente cliente : clientes) {
            if(cliente.getModel().equals(rowKey))
                return cliente;
        }
        
        return null;
    }

    @Override
    public String getRowKey(Cliente cliente) {
        return cliente.getModel();
    }
}
                    