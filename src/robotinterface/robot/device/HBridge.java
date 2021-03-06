/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package robotinterface.robot.device;

import java.nio.ByteBuffer;
import robotinterface.robot.Robot;
import robotinterface.robot.simulation.VirtualDevice;

/**
 *
 * @author antunes
 */
public class HBridge extends Device implements VirtualDevice {

    private int LeftWheelSpeed;
    private int RightWheelSpeed;

    public HBridge() {
    }

    @Override
    public void setState(ByteBuffer data) {
        if (data.remaining() == 2) {
            if (data.get() == 0) {
                LeftWheelSpeed = data.get();
            } else {
                RightWheelSpeed = data.get();
            }
        }
    }

    @Override
    public void getState(ByteBuffer buffer, Robot robot) {
        buffer.put((byte) 2);
        buffer.put((byte) LeftWheelSpeed);
        buffer.put((byte) RightWheelSpeed);
    }

    @Override
    public void setState(ByteBuffer data, Robot robot) {
        setState(data);
    }

    public void setMotorState(int motor, byte speed) {
        byte[] msg = new byte[5];
        msg[0] = Robot.CMD_SET; //comando get
        msg[1] = getID(); //id
        msg[2] = 2; //tamanho da mensagem (2 bytes)
        msg[3] = (byte) motor; //byte 1 - motor
        msg[4] = speed; //byte 2 - velocidade
        send(msg); //envia mensagem
        if (motor == 0) {
            this.LeftWheelSpeed = speed;
        } else {
            this.RightWheelSpeed = speed;
        }
    }

    public void setFullState(byte speedM1, byte speedM2) {
        byte[] msg = new byte[10];
        msg[0] = Robot.CMD_SET; //comando get
        msg[1] = getID(); //id
        msg[2] = 2; //tamanho da mensagem (2 bytes)
        msg[3] = 0;
        msg[4] = speedM1;
        msg[5] = Robot.CMD_SET; //comando get
        msg[6] = getID(); //id
        msg[7] = 2; //tamanho da mensagem (2 bytes)
        msg[8] = 1;
        msg[9] = speedM2;
        send(msg);
        this.LeftWheelSpeed = speedM1;
        this.RightWheelSpeed = speedM2;
    }

    public int getLeftWheelSpeed() {
        return LeftWheelSpeed / 2;
    }

    public int getRightWheelSpeed() {
        return RightWheelSpeed / 2;
    }

    @Override
    public String stateToString() {
        return "";
    }

    @Override
    public int getClassID() {
        return 2;
    }

    public static double realToVirtualVelocityConvert(int v) {
        //return -7.7 + 1.19*v + 0.1*(v*v) + -9.29*(v*v*v);
        return v;
    }

    @Override
    public void updateRobot(Robot robot) {
//        robot.setRightWheelSpeed(realToVirtualVelocityConvert(RightWheelSpeed));
//        robot.setLeftWheelSpeed(realToVirtualVelocityConvert(LeftWheelSpeed));
        robot.setRightWheelSpeed(RightWheelSpeed);
        robot.setLeftWheelSpeed(LeftWheelSpeed);
    }

    @Override
    public String getName() {
        return "Motores";
    }

	@Override
	public void resetState() {
		LeftWheelSpeed = 0;
		RightWheelSpeed = 0;
	}
}
