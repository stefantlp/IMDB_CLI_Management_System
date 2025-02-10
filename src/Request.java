package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Request {
    public enum RequestType {
        DELETE_ACCOUNT, ACTOR_ISSUE, MOVIE_ISSUE, OTHERS
    }
    private RequestType requestType;
    private LocalDateTime creationDate;
    private String titleOrName;
    private String problemDescription;
    private String requestingUsername;
    private String assignedUsername;

    public static class RequestsHolder {
        private static List<Request> requestList = new ArrayList<>();

        public static void addRequest(Request request) {
            requestList.add(request);
        }

        public static void deleteRequest(Request request) {
            requestList.remove(request);
        }

        public static List<Request> getRequestList() {
            return requestList;
        }
    }
     public Request() {
        // setRequestType(null);
        // setCreationDate(null);
        setTitleOrName("");
        setProblemDescription("");
        setCreatedUsername("");
        setAssignedUsername("");
    }
    public Request(RequestType requestType, LocalDateTime creationDate, String titleOrName,
                   String problemDescription, String requestingUsername, String assignedUsername) {
        setRequestType(requestType);
        setCreationDate(creationDate);
        setTitleOrName(titleOrName);
        setProblemDescription(problemDescription);
        setCreatedUsername(requestingUsername);
        setAssignedUsername(assignedUsername);
    }
    public RequestType getRequestType() {
            return requestType;
        }
        public void setRequestType(RequestType requestType) {
            this.requestType = requestType;
        }

        public LocalDateTime getCreationDate() {
            return creationDate;
        }

        public void setCreationDate(LocalDateTime creationDate) {
            this.creationDate = creationDate;
        }

        public String getTitleOrName() {
            return titleOrName;
        }

        public void setTitleOrName(String titleOrName) {
            this.titleOrName = titleOrName;
        }

        public String getProblemDescription() {
            return problemDescription;
        }

        public void setProblemDescription(String problemDescription) {
            this.problemDescription = problemDescription;
        }

        public String getRequestingUsername() {
            return requestingUsername;
        }

        public void setCreatedUsername(String requestingUsername) {
            this.requestingUsername = requestingUsername;
        }

        public String getAssignedUsername() {
            return assignedUsername;
        }

        public void setAssignedUsername(String assignedUsername) {
            this.assignedUsername = assignedUsername;
        }
    }