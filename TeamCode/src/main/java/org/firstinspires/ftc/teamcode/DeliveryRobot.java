package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.ArrayList;
import java.util.List;

@TeleOp(name = "FGC Delivery Robot", group = "FGC_2021")
public class DeliveryRobot extends LinearOpMode {
    List<DcMotor> motors = new ArrayList<>();


    @Override
    public void runOpMode() throws InterruptedException {
        motors.add(hardwareMap.get(DcMotor.class, "leftMotor"));
        motors.add(hardwareMap.get(DcMotor.class, "rightMotor"));
        motors.add(hardwareMap.get(DcMotor.class, "backLeft"));
        motors.add(hardwareMap.get(DcMotor.class, "backRight"));
        waitForStart();
        while(opModeIsActive()) {
            double pwr = 0.75;
            motors.get(0).setPower(-pwr*gamepad1.left_stick_x+gamepad1.left_stick_y);
            motors.get(1).setPower(-pwr*gamepad1.left_stick_x-gamepad1.left_stick_y);
            motors.get(2).setPower(-pwr*gamepad1.left_stick_x+gamepad1.left_stick_y);
            motors.get(3).setPower(-pwr*gamepad1.left_stick_x-gamepad1.left_stick_y);
        }
    }
}