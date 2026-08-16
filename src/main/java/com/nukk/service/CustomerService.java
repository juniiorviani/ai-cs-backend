package com.nukk.service;

import com.nukk.model.Customer;
import com.nukk.model.FeatureAdoption;
import com.nukk.model.TimelineEvent;
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

    private static List<FeatureAdoption> fa(Object... pairs) {
        java.util.ArrayList<FeatureAdoption> list = new java.util.ArrayList<>();
        for (int i = 0; i < pairs.length; i += 2) {
            list.add(new FeatureAdoption((String) pairs[i], (Integer) pairs[i + 1]));
        }
        return list;
    }

    private void seed() {
        add(new Customer(
            "northwind-logistics", "Northwind Logistics", "northwind-logistics.com", "Logistics & Supply Chain", "Enterprise",
            12400, 88, 8420, 12.4,
            List.of(1580, 1640, 1720, 1690, 1810, 1870, 1920, 1960, 2010, 2080, 2140, 2190),
            120, 108, 1,
            List.of(
                new Ticket("NWL-2214", "Bulk export timing out on 50k rows", "Medium", "Open", "2026-08-11", "Neutral"),
                new Ticket("NWL-2190", "SSO group mapping question", "Low", "Resolved", "2026-07-28", "Positive"),
                new Ticket("NWL-2151", "Request: webhook retries dashboard", "Low", "Resolved", "2026-07-09", "Positive")),
            fa("Automations", 92, "Reporting", 84, "API", 78, "Integrations", 71),
            List.of(
                new TimelineEvent("2026-08-08", "QBR completed", "Expansion to the EU warehouse team agreed for Q4.", "mdi-presentation", "success"),
                new TimelineEvent("2026-07-15", "Seat expansion", "Added 20 seats for the dispatch team.", "mdi-account-multiple-plus", "primary"),
                new TimelineEvent("2026-06-02", "NPS survey", "Scored 9 - cited automation reliability.", "mdi-emoticon-happy-outline", "success")),
            "Priya Raman", "Dana Whitfield", "dana.whitfield@northwind-logistics.com",
            "2023-02-14", "2027-02-14", "2026-08-16", 9));

        add(new Customer(
            "vertex-analytics", "Vertex Analytics", "vertexanalytics.io", "Data & BI", "Business",
            8900, 41, 1180, -38.6,
            List.of(640, 620, 590, 560, 520, 470, 430, 380, 340, 300, 280, 260),
            60, 19, 5,
            List.of(
                new Ticket("VTX-8871", "Dashboards loading blank after last release", "Urgent", "Open", "2026-08-13", "Negative"),
                new Ticket("VTX-8860", "Scheduled reports arriving hours late", "High", "Open", "2026-08-10", "Negative"),
                new Ticket("VTX-8842", "Data warehouse sync failing nightly", "High", "Open", "2026-08-04", "Negative"),
                new Ticket("VTX-8830", "How do we export raw events?", "Medium", "Pending", "2026-07-30", "Neutral"),
                new Ticket("VTX-8811", "Invoice discrepancy for July", "Medium", "Open", "2026-07-22", "Negative")),
            fa("Automations", 18, "Reporting", 34, "API", 12, "Integrations", 9),
            List.of(
                new TimelineEvent("2026-08-12", "Champion left the account", "Head of Data moved to another company; no replacement introduced.", "mdi-account-off", "error"),
                new TimelineEvent("2026-07-25", "Escalation opened", "Sync reliability escalated to engineering.", "mdi-alert-octagon", "error"),
                new TimelineEvent("2026-06-18", "Renewal conversation postponed", "Customer asked to revisit in September.", "mdi-calendar-remove", "warning")),
            "Marcus Bell", "Ivan Petrov", "ivan.petrov@vertexanalytics.io",
            "2024-05-06", "2026-11-06", "2026-08-05", 4));

        add(new Customer(
            "lumina-health", "Lumina Health", "luminahealth.org", "Healthcare", "Enterprise",
            21500, 72, 6240, -6.1,
            List.of(1720, 1690, 1660, 1640, 1610, 1580, 1560, 1540, 1520, 1500, 1480, 1460),
            210, 154, 3,
            List.of(
                new Ticket("LUM-4402", "Audit log retention needs to reach 7 years", "High", "Open", "2026-08-09", "Neutral"),
                new Ticket("LUM-4388", "Role permissions too coarse for nursing staff", "Medium", "Open", "2026-08-01", "Negative"),
                new Ticket("LUM-4361", "Training session for the new clinic", "Low", "Pending", "2026-07-19", "Positive")),
            fa("Automations", 61, "Reporting", 88, "API", 44, "Integrations", 57),
            List.of(
                new TimelineEvent("2026-08-06", "Security review passed", "Annual vendor assessment approved for another year.", "mdi-shield-check", "success"),
                new TimelineEvent("2026-07-11", "Adoption dip flagged", "Two clinics stopped logging in after a staffing change.", "mdi-trending-down", "warning"),
                new TimelineEvent("2026-05-29", "Contract amendment", "Added HIPAA BAA addendum.", "mdi-file-document-edit", "primary")),
            "Priya Raman", "Dr. Alice Moreau", "a.moreau@luminahealth.org",
            "2022-09-30", "2026-09-30", "2026-08-15", 7));

        add(new Customer(
            "bluepeak-retail", "Bluepeak Retail", "bluepeakretail.com", "Retail", "Growth",
            5400, 91, 5310, 21.8,
            List.of(820, 880, 940, 1010, 1060, 1120, 1180, 1240, 1290, 1340, 1400, 1460),
            45, 43, 0,
            List.of(
                new Ticket("BPR-1902", "Shopify integration mapping", "Low", "Resolved", "2026-07-24", "Positive"),
                new Ticket("BPR-1875", "Add second store to workspace", "Low", "Resolved", "2026-06-30", "Positive")),
            fa("Automations", 88, "Reporting", 79, "API", 65, "Integrations", 94),
            List.of(
                new TimelineEvent("2026-08-10", "Case study agreed", "Marketing approved a public reference story.", "mdi-star-outline", "success"),
                new TimelineEvent("2026-07-02", "Upsell closed", "Upgraded from Starter to Growth.", "mdi-arrow-up-bold-circle", "primary")),
            "Elena Duarte", "Tom Halvorsen", "tom@bluepeakretail.com",
            "2024-01-18", "2027-01-18", "2026-08-16", 10));

        add(new Customer(
            "orbit-fintech", "Orbit Fintech", "orbitfintech.com", "Financial Services", "Enterprise",
            16800, 34, 940, -52.3,
            List.of(900, 860, 800, 740, 660, 580, 500, 430, 360, 300, 250, 210),
            140, 22, 6,
            List.of(
                new Ticket("ORB-7731", "Latency spikes during EOD reconciliation", "Urgent", "Open", "2026-08-14", "Negative"),
                new Ticket("ORB-7720", "Missing transactions in export", "Urgent", "Open", "2026-08-12", "Negative"),
                new Ticket("ORB-7702", "SOC 2 evidence request overdue", "High", "Open", "2026-08-06", "Negative"),
                new Ticket("ORB-7688", "Onboarding for the risk team never finished", "High", "Pending", "2026-07-27", "Negative"),
                new Ticket("ORB-7671", "Contract terms clarification", "Medium", "Open", "2026-07-18", "Neutral"),
                new Ticket("ORB-7650", "Requesting downgrade options", "High", "Open", "2026-07-09", "Negative")),
            fa("Automations", 11, "Reporting", 22, "API", 31, "Integrations", 8),
            List.of(
                new TimelineEvent("2026-08-13", "Downgrade requested", "Procurement asked for pricing on a smaller plan.", "mdi-arrow-down-bold-circle", "error"),
                new TimelineEvent("2026-07-31", "Executive sponsor unresponsive", "Three outreach attempts with no reply.", "mdi-email-alert", "error"),
                new TimelineEvent("2026-06-20", "Competitor evaluation", "Customer mentioned an ongoing vendor review.", "mdi-compare", "warning")),
            "Marcus Bell", "Rebecca Lyons", "r.lyons@orbitfintech.com",
            "2023-10-01", "2026-10-01", "2026-07-29", 3));

        add(new Customer(
            "corewave-systems", "Corewave Systems", "corewave.dev", "Software", "Business",
            9700, 79, 4980, 4.9,
            List.of(1120, 1140, 1130, 1160, 1180, 1170, 1200, 1210, 1220, 1240, 1250, 1270),
            80, 67, 2,
            List.of(
                new Ticket("CWS-5510", "Rate limit headers missing on v2 API", "Medium", "Open", "2026-08-12", "Neutral"),
                new Ticket("CWS-5488", "Sandbox environment for CI", "Medium", "Open", "2026-08-03", "Neutral"),
                new Ticket("CWS-5451", "Terraform provider docs feedback", "Low", "Resolved", "2026-07-14", "Positive")),
            fa("Automations", 74, "Reporting", 58, "API", 96, "Integrations", 69),
            List.of(
                new TimelineEvent("2026-08-04", "API usage milestone", "Crossed 1M monthly API calls.", "mdi-api", "success"),
                new TimelineEvent("2026-06-25", "New workspace admin", "Platform team took ownership from engineering.", "mdi-account-switch", "primary")),
            "Elena Duarte", "Sofia Nakamura", "sofia@corewave.dev",
            "2023-06-12", "2026-12-12", "2026-08-16", 8));

        add(new Customer(
            "sunset-media", "Sunset Media", "sunsetmedia.tv", "Media & Entertainment", "Starter",
            3200, 57, 1620, -14.2,
            List.of(520, 505, 490, 470, 460, 445, 430, 420, 405, 395, 385, 375),
            25, 13, 2,
            List.of(
                new Ticket("SNM-3320", "Video asset uploads failing over 2GB", "High", "Open", "2026-08-08", "Negative"),
                new Ticket("SNM-3301", "Need more granular publishing roles", "Medium", "Pending", "2026-07-21", "Neutral")),
            fa("Automations", 32, "Reporting", 47, "API", 19, "Integrations", 38),
            List.of(
                new TimelineEvent("2026-07-30", "Budget freeze announced", "Customer signalled tighter tooling budget for 2027.", "mdi-cash-remove", "warning"),
                new TimelineEvent("2026-06-14", "Onboarding refresh", "Re-trained the editorial team on workflows.", "mdi-school", "primary")),
            "Elena Duarte", "Marco Silveira", "marco@sunsetmedia.tv",
            "2025-03-05", "2027-03-05", "2026-08-13", 6));

        add(new Customer(
            "atlas-manufacturing", "Atlas Manufacturing", "atlasmfg.com", "Manufacturing", "Business",
            14300, 66, 3870, -9.7,
            List.of(1080, 1060, 1040, 1020, 1000, 980, 965, 950, 935, 920, 905, 890),
            95, 58, 3,
            List.of(
                new Ticket("ATL-6612", "ERP connector drops records overnight", "High", "Open", "2026-08-10", "Negative"),
                new Ticket("ATL-6590", "Plant floor tablets logged out repeatedly", "Medium", "Open", "2026-08-02", "Negative"),
                new Ticket("ATL-6544", "Quarterly usage report request", "Low", "Resolved", "2026-07-08", "Neutral")),
            fa("Automations", 49, "Reporting", 63, "API", 41, "Integrations", 52),
            List.of(
                new TimelineEvent("2026-08-05", "Second plant paused rollout", "Rollout to the Monterrey plant put on hold.", "mdi-pause-circle", "warning"),
                new TimelineEvent("2026-06-28", "Integration project kicked off", "ERP connector project started with IT.", "mdi-rocket-launch", "primary")),
            "Priya Raman", "Grace Okoye", "g.okoye@atlasmfg.com",
            "2022-11-22", "2026-11-22", "2026-08-14", 6));

        add(new Customer(
            "pixelforge-studio", "Pixelforge Studio", "pixelforge.studio", "Design Agency", "Starter",
            2600, 28, 310, -61.5,
            List.of(310, 290, 260, 230, 200, 170, 140, 120, 100, 85, 70, 55),
            18, 4, 4,
            List.of(
                new Ticket("PXF-2210", "Cancel auto-renew before the next cycle", "Urgent", "Open", "2026-08-15", "Negative"),
                new Ticket("PXF-2201", "Two failed payments on the company card", "High", "Open", "2026-08-09", "Negative"),
                new Ticket("PXF-2188", "Cannot find exported brand assets", "Medium", "Open", "2026-07-26", "Negative"),
                new Ticket("PXF-2170", "Team seats unused since June", "Medium", "Pending", "2026-07-12", "Neutral")),
            fa("Automations", 6, "Reporting", 14, "API", 2, "Integrations", 11),
            List.of(
                new TimelineEvent("2026-08-15", "Cancellation request", "Asked support how to stop the renewal.", "mdi-exit-run", "error"),
                new TimelineEvent("2026-08-09", "Payment failed twice", "Card declined on both retry attempts.", "mdi-credit-card-off", "error"),
                new TimelineEvent("2026-06-05", "Team downsized", "Agency reduced headcount by 40%.", "mdi-account-minus", "warning")),
            "Marcus Bell", "Lena Fischer", "lena@pixelforge.studio",
            "2025-01-09", "2026-09-09", "2026-07-21", 2));

        add(new Customer(
            "everline-energy", "Everline Energy", "everline-energy.com", "Energy & Utilities", "Enterprise",
            11200, 84, 7150, 8.3,
            List.of(1480, 1520, 1560, 1590, 1610, 1650, 1680, 1710, 1740, 1780, 1810, 1850),
            105, 91, 1,
            List.of(
                new Ticket("EVL-9910", "Add SAML attribute for regional access", "Medium", "Open", "2026-08-07", "Neutral"),
                new Ticket("EVL-9885", "Feedback on the new alerting UI", "Low", "Resolved", "2026-07-16", "Positive")),
            fa("Automations", 81, "Reporting", 90, "API", 62, "Integrations", 73),
            List.of(
                new TimelineEvent("2026-08-01", "Renewal signed early", "Committed to a 24-month term.", "mdi-file-sign", "success"),
                new TimelineEvent("2026-07-04", "New region onboarded", "Nordics operations team went live.", "mdi-earth", "primary")),
            "Priya Raman", "Henrik Solberg", "h.solberg@everline-energy.com",
            "2021-08-19", "2028-08-19", "2026-08-16", 9));
    }
}
