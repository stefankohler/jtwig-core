package org.jtwig.model.expression;

import org.jtwig.context.RenderContext;
import org.jtwig.model.expression.operation.UnaryOperator;
import org.jtwig.model.position.Position;
import org.jtwig.value.JtwigValue;

public class UnaryOperationExpression extends Expression {
    private final UnaryOperator operator;
    private final Expression operand;

    public UnaryOperationExpression(Position position, UnaryOperator operator, Expression operand) {
        super(position);
        this.operator = operator;
        this.operand = operand;
    }

    @Override
    public JtwigValue calculate(RenderContext context) {
        return operator.calculator().calculate(context, getPosition(), operand);
    }
}
