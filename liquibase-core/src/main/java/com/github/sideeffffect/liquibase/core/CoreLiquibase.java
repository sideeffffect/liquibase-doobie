package com.github.sideeffffect.liquibase.core;

import liquibase.Scope;
import liquibase.UpdateSummaryOutputEnum;
import liquibase.analytics.configuration.AnalyticsArgs;
import liquibase.command.CommandScope;
import liquibase.command.core.UpdateCommandStep;
import liquibase.command.core.helpers.DbUrlConnectionArgumentsCommandStep;
import liquibase.command.core.helpers.ShowSummaryArgument;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.ui.LoggerUIService;

import java.sql.Connection;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;

public class CoreLiquibase {
    public static void runMigration(Connection connection, String changeLogFile) throws Exception {
        var db = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));
        var updateCommand = new CommandScope(UpdateCommandStep.COMMAND_NAME);
        updateCommand.addArgumentValue(DbUrlConnectionArgumentsCommandStep.DATABASE_ARG, db);
        updateCommand.addArgumentValue(UpdateCommandStep.CHANGELOG_FILE_ARG, changeLogFile);
        updateCommand.addArgumentValue(ShowSummaryArgument.SHOW_SUMMARY_OUTPUT, UpdateSummaryOutputEnum.LOG);
        Scope.enter(Map.of(
                Scope.Attr.ui.name(), new LoggerUIService(), // https://github.com/liquibase/liquibase/issues/2396
                AnalyticsArgs.ENABLED.getKey(), Boolean.FALSE, // https://github.com/liquibase/liquibase/pull/6412
                AnalyticsArgs.LOG_LEVEL.getKey(), Level.INFO // https://github.com/liquibase/liquibase/pull/6510
        ));
        var result = updateCommand.execute().getResults();
        var statusCode = Optional.ofNullable(result.get("statusCode"));
        if (statusCode.isPresent() && !statusCode.get().equals(0)) {
            throw new RuntimeException("Unexpected Liquibase result: " + result);
        }
    }
}
