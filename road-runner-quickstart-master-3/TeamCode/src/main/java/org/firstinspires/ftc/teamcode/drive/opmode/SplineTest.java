package org.firstinspires.ftc.teamcode.drive.opmode;

import android.graphics.drawable.GradientDrawable;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.path.heading.ConstantInterpolator;
import com.acmerobotics.roadrunner.path.heading.HeadingInterpolator;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.teamcode.drive.mecanum.SampleMecanumDriveBase;
import org.firstinspires.ftc.teamcode.drive.mecanum.SampleMecanumDriveREV;
import org.firstinspires.ftc.teamcode.drive.mecanum.SampleMecanumDriveREVOptimized;

/*
 * This is an example of a more complex path to really test the tuning.
 */
@Autonomous(group = "drive")
public class SplineTest extends LinearOpMode {

    BNO055IMU imu;
    Orientation angles;

    @Override
    public void runOpMode() throws InterruptedException {

        imu = hardwareMap.get(BNO055IMU.class, "imu");
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.RADIANS;
        imu.initialize(parameters);

        angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);


        SampleMecanumDriveBase drive = new SampleMecanumDriveREVOptimized(hardwareMap);
        telemetry.addData("ANGLE BEFORE",angles.firstAngle);

        waitForStart();

        if (isStopRequested()) return;

        drive.followTrajectorySync(
                drive.trajectoryBuilder()
                        .lineTo(new Vector2d(30, 30), new ConstantInterpolator(0))

                        .build()
        );


        sleep(500);

        angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
        telemetry.addData("ANGLE BETWEEN",angles.firstAngle);

        sleep(2000);

        drive.followTrajectorySync(
                drive.trajectoryBuilder()
                        .reverse()
                        .splineTo(new Pose2d(30, 30, 0), new ConstantInterpolator(0))
                        .build()
        );

        sleep(500);

        angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
        telemetry.addData("ANGLE END",angles.firstAngle);
        telemetry.update();

        sleep(20000);
    }
}
