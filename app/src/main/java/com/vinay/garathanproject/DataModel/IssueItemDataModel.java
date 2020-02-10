package com.vinay.garathanproject.DataModel;

public class IssueItemDataModel {

    private String requestId, issueDescription, issueDate;

    public IssueItemDataModel() {
    }

    public IssueItemDataModel(String requestId, String issueDescription, String issueDate) {
        this.requestId = requestId;
        this.issueDescription = issueDescription;
        this.issueDate = issueDate;
    }

    public String getRequestId(){
        return requestId;
    }

    public void setRequestId(String requestId){
        this.requestId = requestId;
    }

    public String getIssueDescription(){
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription){
        this.issueDescription = issueDescription;
    }

    public String getIssueDate(){
        return issueDate;
    }

    public void setIssueDate(String issueDate){
        this.issueDate = issueDate;
    }
}
