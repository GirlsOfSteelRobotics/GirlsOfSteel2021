package frc.robot.lib;

import edu.wpi.first.wpilibj.controller.PIDController;

public class WpiPidPropertyBuilder extends PidProperty.Builder implements IPidPropertyBuilder {
    private final PIDController m_pidController;

    public static IPidPropertyBuilder createBuilder(String baseName, boolean isConstant, PIDController motor) {
        return new WpiPidPropertyBuilder(baseName, isConstant, motor);
    }

    private WpiPidPropertyBuilder(String baseName, boolean isConstant, PIDController motor) {
        super(baseName, isConstant);
        m_pidController = motor;
    }

    @Override
    public IPidPropertyBuilder addP(double defaultValue) {
        addP(defaultValue, m_pidController::setP);
        return this;
    }

    @Override
    public IPidPropertyBuilder addI(double defaultValue) {
        addI(defaultValue, m_pidController::setI);
        return this;
    }

    @Override
    public IPidPropertyBuilder addD(double defaultValue) {
        addD(defaultValue, m_pidController::setD);
        return this;
    }

    @Override
    public IPidPropertyBuilder addFF(double defaultValue) {
        throw new UnsupportedOperationException();
    }

    @Override
    public IPidPropertyBuilder addMaxVelocity(double defaultValue) {
        throw new UnsupportedOperationException();
    }

    @Override
    public IPidPropertyBuilder addMaxAcceleration(double defaultValue) {
        throw new UnsupportedOperationException();
    }
}
