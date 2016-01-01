package com.seniror.util;

import java.util.Collections;

import org.pegdown.Extensions;
import org.pegdown.LinkRenderer;
import org.pegdown.PegDownProcessor;
import org.pegdown.ToHtmlSerializer;
import org.pegdown.VerbatimSerializer;
import org.pegdown.ast.RootNode;
import org.springframework.stereotype.Service;

@Service
public class MarkdownService {

	public String toHtml(String markdownSource) {
		PegDownProcessor pegdown = new PegDownProcessor(Extensions.ALL);
        RootNode astRoot = pegdown.parseMarkdown(markdownSource.toCharArray());
        ToHtmlSerializer serializer = new ToHtmlSerializer(new LinkRenderer(),
                Collections.singletonMap(VerbatimSerializer.DEFAULT, PygmentsVerbatimSerializer.INSTANCE));
        return serializer.toHtml(astRoot);
	}
}
