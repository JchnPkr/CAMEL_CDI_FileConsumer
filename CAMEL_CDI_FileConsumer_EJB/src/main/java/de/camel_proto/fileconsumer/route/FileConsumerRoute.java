
package de.camel_proto.fileconsumer.route;

import javax.inject.Inject;

import org.apache.camel.Endpoint;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.Uri;
import org.apache.logging.log4j.Logger;

@DoNotDiscover
public class FileConsumerRoute extends RouteBuilder {
	public static String FILE_ROUTE = "fileRoute";

	@Inject
	@Uri("file:{{input.file.path}}?noop=true")
	private Endpoint inputEndpoint;

	@Inject
	@Uri("jms:queue:{{jms.camel.queue}}")
	private Endpoint queue;

	@Inject
	private Logger logger;

	@Override
	public void configure() {
		logger.info("--- starting file consumer route configure...");

		from(inputEndpoint).routeId(FILE_ROUTE)
				.log(LoggingLevel.INFO, "messages", "pusing to queue:  ${body}")
				.to(queue);
	}
}