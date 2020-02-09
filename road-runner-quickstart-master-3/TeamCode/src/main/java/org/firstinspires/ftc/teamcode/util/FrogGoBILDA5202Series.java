package org.firstinspires.ftc.teamcode.util;

import com.qualcomm.robotcore.hardware.configuration.DistributorInfo;
import com.qualcomm.robotcore.hardware.configuration.annotations.DeviceProperties;
import com.qualcomm.robotcore.hardware.configuration.annotations.ExpansionHubPIDFPositionParams;
import com.qualcomm.robotcore.hardware.configuration.annotations.ExpansionHubPIDFVelocityParams;
import com.qualcomm.robotcore.hardware.configuration.annotations.MotorType;

import org.firstinspires.ftc.robotcore.external.navigation.Rotation;

@MotorType(ticksPerRev=383.6, gearing=13.7, maxRPM=435, orientation=Rotation.CCW)
@DeviceProperties(xmlTag="goBILDA5202SeriesMotorfrog", name="GoBILDA 5202 seriesfrog", builtIn = true)
@DistributorInfo(distributor="goBILDA_distributorfrog", model="goBILDA-5202frog", url="https://www.gobilda.com/5202-series-yellow-jacket-planetary-gear-motors/frog")
@ExpansionHubPIDFVelocityParams(P=2.0, I=0.5, F=11.1)
@ExpansionHubPIDFPositionParams(P=5.0)
public interface FrogGoBILDA5202Series
    {
    }