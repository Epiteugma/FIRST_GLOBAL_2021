package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.ArrayList;
import java.util.List;

@TeleOp(name = "FGC Intake Robot", group = "FGC_2021")
public class IntakeRobot extends LinearOpMode {
    List<DcMotor> motors = new ArrayList<>();


    @Override
    public void runOpMode() throws InterruptedException {
        motors.add(hardwareMap.get(DcMotor.class, "leftMotor"));
        motors.add(hardwareMap.get(DcMotor.class, "rightMotor"));
        motors.add(hardwareMap.get(DcMotor.class, "backLeft"));
        motors.add(hardwareMap.get(DcMotor.class, "backRight"));
        motors.add(hardwareMap.get(DcMotor.class, "armLift"));
        CRServo claw = hardwareMap.get(CRServo.class, "armClaw");
        waitForStart();
        int armPos = 0;
        double power = 0;
        while(opModeIsActive()) {
            motors.get(0).setPower(-gamepad1.left_stick_x+gamepad1.left_stick_y);
            motors.get(1).setPower(-gamepad1.left_stick_x-gamepad1.left_stick_y);
            motors.get(2).setPower(-gamepad1.left_stick_x+gamepad1.left_stick_y);
            motors.get(3).setPower(-gamepad1.left_stick_x-gamepad1.left_stick_y);

            if(gamepad1.a) {
                motors.get(4).setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                armPos = motors.get(4).getCurrentPosition();
                motors.get(4).setPower(-0.5);
            }
            else if(gamepad1.y) {
                motors.get(4).setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                armPos = motors.get(4).getCurrentPosition();
                motors.get(4).setPower(0.5);

            }
            else {
                motors.get(4).setTargetPosition(armPos);
                motors.get(4).setMode(DcMotor.RunMode.RUN_TO_POSITION);
                motors.get(4).setPower(1);
            }


            if(gamepad1.dpad_up){
                power = -1;
                claw.setPower(power);
            }
            else if(gamepad1.dpad_down){
                power = 0;
                claw.setPower(power);
            }
            else{
                claw.setPower(power);
            }
        }
    }
}