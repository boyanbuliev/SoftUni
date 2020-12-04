package onlineShop.models.products.computers;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

import static onlineShop.common.constants.ExceptionMessages.*;

public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;

    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public double getOverallPerformance() {
        return super.getOverallPerformance() +
                this.components.stream().mapToDouble(Component::getOverallPerformance).average().orElse(0);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + components.stream().mapToDouble(Component::getPrice).sum() +
                peripherals.stream().mapToDouble(Peripheral::getPrice).sum();
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public void addComponent(Component component) {
        if (this.components.contains(component)) {
            throw new IllegalArgumentException(String.format(EXISTING_COMPONENT,
                    component.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
        }
        this.components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        for (Component component : components) {
            if (component.getClass().getSimpleName().equals(componentType)) {
                components.remove(component);
                return component;
            }
        }
        throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT, componentType,
                this.getClass().getSimpleName(), getId()));
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        if (this.peripherals.contains(peripheral)) {
            throw new IllegalArgumentException(String.format(EXISTING_COMPONENT,
                    peripheral.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
        }
        this.peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        for (Peripheral peripheral : peripherals) {
            if (peripheral.getClass().getSimpleName().equals(peripheralType)) {
                peripherals.remove(peripheral);
                return peripheral;
            }
        }
        throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL, peripheralType,
                this.getClass().getSimpleName(), getId()));
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Overall Performance: %.2f. Price: %.2f - %s: %s %s (Id: %d)",
                this.getOverallPerformance(), this.getPrice(), this.getClass().getSimpleName(),
                this.getManufacturer(), this.getModel(), this.getId()))
                .append(System.lineSeparator())
                .append(String.format(" Components (%d):", this.components.size()))
                .append(System.lineSeparator());
        for (Component component : components) {
            sb.append(String.format("  %s", component))
                    .append(System.lineSeparator());
        }
        sb.append(String.format(" Peripherals (%d); Average Overall Performance (%.2f):",
                this.peripherals.size(),
                this.peripherals.stream().mapToDouble(Product::getOverallPerformance)
                        .average().orElse(0)))
                .append(System.lineSeparator());
        for (Peripheral peripheral : peripherals) {
            sb.append(String.format("  %s", peripheral))
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
