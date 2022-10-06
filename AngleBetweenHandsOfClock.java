class AngleBetweenHandsOfClock {
public double angleClock(int hour, int minutes) {

	double angle = 0;
	double minAngle = minutes * 6;
	double hrAngle = hour * 30 + (minAngle / 360 * 30);
	hrAngle = hrAngle % 360;

	angle = Math.abs(hrAngle - minAngle);

	angle = Math.min(angle, 360 - angle);

	return angle;
}
}