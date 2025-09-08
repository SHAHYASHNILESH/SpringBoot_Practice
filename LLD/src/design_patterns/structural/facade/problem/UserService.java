package design_patterns.structural.facade.problem;

// Microservice for User Management
class UserService {
    public String getUserDetails(String userId) {
        // Simulate fetching user details
        return "User details for userId: " + userId;
    }
}