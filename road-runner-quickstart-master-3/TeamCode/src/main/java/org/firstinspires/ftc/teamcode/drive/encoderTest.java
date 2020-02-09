package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "ENCODER TEST")
public class encoderTest extends OpMode {

    public DcMotor leftFront, leftRear, rightFront, rightRear;

    @Override
    public void init() {
        leftFront = hardwareMap.dcMotor.get("lf");
        leftRear = hardwareMap.dcMotor.get("lr");
        rightFront = hardwareMap.dcMotor.get("rf");
        rightRear = hardwareMap.dcMotor.get("rr");

    }

    @Override
    public void loop() {
        telemetry.addData("LF : ", leftFront.getCurrentPosition());
        telemetry.addData("LR : ", leftRear.getCurrentPosition());
        telemetry.addData("RF : ", rightFront.getCurrentPosition());
        telemetry.addData("RR : ", rightRear.getCurrentPosition());



    }
}
