package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ComputerManagerTests {
    private ComputerManager computerManager;
    private Computer computer1;
    private Computer computer2;
    private Computer computer3;
    List<Computer> computers;

    @Before
    public void init() {
        computerManager = new ComputerManager();
        computer1 = new Computer("GIGABYTE", "Pesho", 1.5);
        computer2 = new Computer("MSI", "GOSHO", 2.5);
        computer3 = new Computer("ASROCK", "IVAN", 3.5);
    }

    @Test
    public void testAddComputerShouldProperlyAddComputer() {
        computerManager.addComputer(computer1);
        assertEquals(1, computerManager.getCount());
        assertEquals(computer1, computerManager.getComputer(computer1.getManufacturer(), computer1.getModel()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerShouldThrowWhenNullIsAdded() {
        computerManager.addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerShouldThrowWhenItemAlreadyExists() {
        computerManager.addComputer(computer1);
        computerManager.addComputer(computer1);
    }

    @Test
    public void testGetComputersShouldReturnComputers() {
        addComputers(3);
        assertNotNull(computerManager.getComputers());
        assertEquals(computers, computerManager.getComputers());
    }

    @Test
    public void testGetCountShouldReturnProperly() {
        assertEquals(0, computerManager.getCount());
        addComputers(3);
        assertEquals(3, computerManager.getCount());
    }

    @Test
    public void testRemoveComputerShouldProperlyRemoveComputer() {
        computerManager.addComputer(computer1);
        assertEquals(1, computerManager.getCount());
        assertEquals(computer1, computerManager.removeComputer(
                computer1.getManufacturer(), computer1.getModel()));
        assertEquals(0, computerManager.getCount());
    }

    @Test
    public void testGetComputerShouldReturnProperComputer() {
        computerManager.addComputer(computer1);
        assertEquals(computer1, computerManager.getComputer(computer1.getManufacturer(),
                computer1.getModel()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerShouldThrowWhenNullIsSentForManufacturer() {
        computerManager.addComputer(computer1);
        computerManager.addComputer(computer2);
        computerManager.addComputer(computer3);
        computerManager.getComputer(null, computer1.getModel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerShouldThrowWhenNullIsSentForModel() {
        computerManager.addComputer(computer1);
        computerManager.addComputer(computer2);
        computerManager.addComputer(computer3);
        computerManager.getComputer(computer1.getManufacturer(), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerShouldThrowWhenComputerIsNotFound() {
        addComputers(3);
        computerManager.getComputer(computer1.getManufacturer(), computer1.getModel());
    }

    @Test
    public void testGetComputersByManufacturerShouldReturnProperList() {
        addComputersWithSameManufacturer(3);
        computerManager.addComputer(computer1);
        computerManager.addComputer(computer2);
        computerManager.addComputer(computer3);
        assertEquals(computers, computerManager.getComputersByManufacturer("ASUS"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputersByManufacturerShouldThrowWhenNullManufacturerIsSent() {
        addComputers(3);
        computerManager.getComputersByManufacturer(null);
    }

    private void addComputersWithSameManufacturer(int count) {
        computers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Computer computer = new Computer("ASUS", "" + i, i + 0.5);
            computers.add(computer);
            computerManager.addComputer(computer);
        }
    }

    private void addComputers(int count) {
        computers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Computer computer = new Computer("" + i, "1" + i, i + 0.5);
            computers.add(computer);
            computerManager.addComputer(computer);
        }
    }
}