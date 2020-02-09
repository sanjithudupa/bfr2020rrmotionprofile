package org.firstinspires.ftc.teamcode.drive.opmode;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.hardware.motors.GoBILDA5202Series;
import com.qualcomm.hardware.motors.RevRobotics40HdHexMotor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.configuration.typecontainers.MotorConfigurationType;

import org.firstinspires.ftc.teamcode.drive.mecanum.SampleMecanumDriveBase;
import org.firstinspires.ftc.teamcode.drive.mecanum.SampleMecanumDriveREV;
import org.firstinspires.ftc.teamcode.drive.mecanum.SampleMecanumDriveREVOptimized;
import org.firstinspires.ftc.teamcode.util.FrogGoBILDA5202Series;

/*
 * This is a simple routine to test translational drive capabilities.
 */
@Config
@Autonomous(group = "drive")
public class StraightTest extends LinearOpMode {
    public static double DISTANCE = 60;

    private static final MotorConfigurationType MOTOR_CONFIG =
            MotorConfigurationType.getMotorType(FrogGoBILDA5202Series.class);

    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDriveBase drive = new SampleMecanumDriveREVOptimized(hardwareMap);

        Trajectory trajectory = drive.trajectoryBuilder()
                .forward(DISTANCE)
                .build();


        telemetry.addData("TICKS PER REV", MOTOR_CONFIG.getTicksPerRev());
        telemetry.addData("MAX RPM", MOTOR_CONFIG.getMaxRPM());
        telemetry.addData("RPM FRACTION", MOTOR_CONFIG.getAchieveableMaxRPMFraction());
        telemetry.update();

        waitForStart();

        if (isStopRequested()) return;

        drive.followTrajectorySync(trajectory);


        for(double position : drive.getWheelPositions()){

            telemetry.addData("POS: ", position);
        }

        telemetry.update();


        sleep(7500);
    }
}
