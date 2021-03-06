package org.jtwig.parser.parboiled.expression;

import org.jtwig.model.expression.Expression;
import org.jtwig.parser.parboiled.ParserContext;
import org.parboiled.Rule;
import org.parboiled.annotations.Label;

public class AnyExpressionParser extends ExpressionParser<Expression> {
    public AnyExpressionParser(ParserContext context) {
        super(AnyExpressionParser.class, context);
    }

    @Label("Any Expression")
    public Rule ExpressionRule() {
        return FirstOf(
                parserContext().parser(TestOperationExpressionParser.class).ExpressionRule(),
                parserContext().parser(SimpleExpressionParser.class).ExpressionRule()
        );
    }
}
