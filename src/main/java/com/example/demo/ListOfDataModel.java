package com.example.demo;

import java.util.List;

public class ListOfDataModel {
    private List<DataModel> dataModelList;

    @Override
    public String toString() {
        return "ListOfDataModel{" +
                "dataModelList=" + dataModelList +
                '}';
    }

    public List<DataModel> getDataModelList() {
        return dataModelList;
    }

    public void setDataModelList(List<DataModel> dataModelList) {
        this.dataModelList = dataModelList;
    }
}
