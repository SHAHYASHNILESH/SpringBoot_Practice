// This interface defines the contract for the mediator responsible for managing airplane communication and requests for takeoff and landing.

package design_patterns.behavioural.mediator.flightControl;

public interface Mediator {
    void registerAirplane(Airplane airplane);
    void handleTakeoffRequest(Airplane airplane);
    void handleLandingRequest(Airplane airplane);
    void notifyTakeoffComplete(Airplane airplane);
    void notifyLandingComplete(Airplane airplane);
}
