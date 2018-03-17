package ca._4976.powerup.data;

/**
 * This is the data we store in a single tick of a profile.
 */
public final class Moment {

    public final Integer[] commands;

    public final Double[] output, position, velocity;

    public Moment(Integer[] commands, Double[] output, Double[] position, Double velocity[]) {

        this.commands = commands;
        this.output = output;
        this.position = position;
        this.velocity = velocity;
    }
}
