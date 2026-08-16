package com.nukk.service;

import com.nukk.model.Customer;
import com.nukk.model.Ticket;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class CustomerService {

    private final Map<String, Customer> customers = new LinkedHashMap<>();

    public CustomerService() {
        seed();
    }

    public List<Customer> findAll() {
        return List.copyOf(customers.values());
    }

    public Customer findById(String id) {
        return customers.get(id);
    }

    private void add(Customer customer) {
        customers.put(customer.id(), customer);
    }

    private void seed() {
        add(new Customer("CUST-001", "Northwind Analytics", 4200.0, 92, 1180, 1120, 1,
            List.of(new Ticket("TCK-1001", "Question about SSO setup", "closed", "low", "2026-07-02T10:00:00Z")),
            "2026-08-14", "22 months"));

        add(new Customer("CUST-002", "Vega Retail Group", 8600.0, 88, 2340, 2210, 2,
            List.of(
                new Ticket("TCK-1002", "Export to CSV timing out", "closed", "medium", "2026-07-18T09:30:00Z"),
                new Ticket("TCK-1003", "Add new team member", "closed", "low", "2026-08-01T14:00:00Z")),
            "2026-08-15", "31 months"));

        add(new Customer("CUST-003", "Bluepeak Logistics", 3100.0, 75, 640, 700, 3,
            List.of(new Ticket("TCK-1004", "Slow report generation", "open", "medium", "2026-08-05T11:00:00Z")),
            "2026-08-12", "9 months"));

        add(new Customer("CUST-004", "Sunrise Health Partners", 5400.0, 60, 410, 620, 4,
            List.of(
                new Ticket("TCK-1005", "Integration webhook failing intermittently", "open", "high", "2026-08-01T08:15:00Z"),
                new Ticket("TCK-1006", "Billing address update", "closed", "low", "2026-07-20T16:00:00Z")),
            "2026-08-10", "14 months"));

        add(new Customer("CUST-005", "Ferro Manufacturing", 2600.0, 55, 300, 480, 5,
            List.of(new Ticket("TCK-1007", "Dashboard not loading for one user", "open", "medium", "2026-08-06T13:20:00Z")),
            "2026-08-09", "6 months"));

        add(new Customer("CUST-006", "Harbor Freight Co", 3900.0, 45, 260, 510, 6,
            List.of(
                new Ticket("TCK-1008", "Requesting refund for unused seats", "open", "high", "2026-08-04T10:00:00Z"),
                new Ticket("TCK-1009", "API rate limit too low", "open", "medium", "2026-08-07T09:00:00Z")),
            "2026-08-08", "11 months"));

        add(new Customer("CUST-007", "Lumen Financial Services", 7200.0, 35, 150, 640, 8,
            List.of(
                new Ticket("TCK-1010", "Critical: reports showing wrong totals", "open", "high", "2026-08-03T07:45:00Z"),
                new Ticket("TCK-1011", "Login failing for admin users", "open", "high", "2026-08-06T12:00:00Z"),
                new Ticket("TCK-1012", "Asking to cancel subscription", "open", "high", "2026-08-10T15:30:00Z")),
            "2026-07-28", "27 months"));

        add(new Customer("CUST-008", "Acme Logistics", 4200.0, 25, 120, 410, 6,
            List.of(
                new Ticket("TCK-1013", "Login error persisting for 2 weeks", "open", "high", "2026-07-30T08:00:00Z"),
                new Ticket("TCK-1014", "Data export failing", "open", "high", "2026-08-05T09:00:00Z")),
            "2026-07-20", "14 months"));

        add(new Customer("CUST-009", "Ironclad Insurance", 6100.0, 20, 80, 400, 9,
            List.of(
                new Ticket("TCK-1015", "Unhappy with support response time", "open", "high", "2026-07-29T10:00:00Z"),
                new Ticket("TCK-1016", "Threatening to churn - escalated to CSM", "open", "high", "2026-08-08T11:00:00Z"),
                new Ticket("TCK-1017", "Product not meeting expectations", "open", "high", "2026-08-11T09:30:00Z")),
            "2026-07-15", "8 months"));

        add(new Customer("CUST-010", "Cascade Media Group", 5000.0, 95, 1900, 1850, 0,
            List.of(),
            "2026-08-16", "40 months"));
    }
}
