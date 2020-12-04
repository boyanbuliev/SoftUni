package computers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ComputerTest {
    private Computer computer;
    private List<Part> parts;
    Part part1;
    Part part2;
    Part part3;

    @Before
    public void init() {
        this.computer = new Computer("Pesho");
        this.part1 = new Part("CPU", 1.5);
        this.part2 = new Part("RAM", 2.5);
        this.part3 = new Part("GPU", 3.5);
    }

    @Test
    public void testGetName() {
        assertEquals("Pesho", computer.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNameCannotBeNull() {
        new Computer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNameCannotBeEmpty() {
        new Computer("");
    }

    @Test
    public void testGetPartsShouldReturnParts() {
        addparts(3);
        assertEquals(parts, computer.getParts());
    }

    @Test
    public void testGetTotalPrice() {
        addparts(3);
        assertEquals(parts.stream().mapToDouble(Part::getPrice).sum(), computer.getTotalPrice(), 0.0);
    }

    @Test
    public void testAddPartShouldProperlyAddPart() {
        computer.addPart(part1);
        assertNotNull(computer);
        assertEquals(1, computer.getParts().size());
        assertEquals(part1, computer.getPart(part1.getName()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPartShouldThrow() {
        computer.addPart(null);
    }

    @Test
    public void testRemovePartShouldProperlyRemovePart() {
        computer.addPart(part1);
        assertTrue(computer.getParts().contains(part1));
        assertTrue(computer.removePart(part1));
        assertFalse(computer.getParts().contains(part1));
    }

    @Test
    public void testRemoveShouldReturnFalseWhenRemovingNonExistentPart() {
        assertFalse(computer.removePart(part1));
    }

    @Test
    public void testGetPartShouldReturnPart() {
        computer.addPart(part1);
        assertEquals(part1, computer.getPart("CPU"));
    }

    @Test
    public void testGetPartShouldReturnNull() {
        addparts(3);
        assertNull(computer.getPart("CPU"));
    }

    private void addparts(int count) {
        parts = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Part part = new Part("" + i, 0.5 + i);
            computer.addPart(part);
            parts.add(part);
        }
    }


    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Computer
}