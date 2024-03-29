package org.ajincodew.OrderOrchestrator.service;

import java.util.List;

public class OrderWorkflow implements Workflow {

    private final List<WorkflowStep> steps;

    public OrderWorkflow(List<WorkflowStep> steps) {
        this.steps = steps;
    }

    @Override
    public List<WorkflowStep> getSteps() {
        return steps;
    }

}
