package io.github.ashwith.flutter;


import io.github.ashwith.flutter.finders.ByAncestor;
import io.github.ashwith.flutter.finders.ByDescendant;
import io.github.ashwith.flutter.finders.BySemanticsLabel;
import io.github.ashwith.flutter.finders.ByText;
import io.github.ashwith.flutter.finders.ByToolTip;
import io.github.ashwith.flutter.finders.ByType;
import io.github.ashwith.flutter.finders.ByValueKey;
import io.github.ashwith.flutter.finders.PageBack;
import io.appium.java_client.remote.AppiumRemoteWebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Flutter finder implementation of different type of flutter element finder
 *
 * @author ashwith
 * @version 1.0.0
 */
public class FlutterFinder implements ByValueKey, ByType, ByToolTip, ByText, ByAncestor, ByDescendant,
        BySemanticsLabel, PageBack {
    AppiumRemoteWebDriver driver;
    private static final String FINDER_TYPE = "finderType";

    public FlutterFinder(AppiumRemoteWebDriver driver) {
        this.driver = driver;
    }

    @Override
    public FlutterElement byValueKey(String key) {
        FlutterElement flutterElement = new FlutterElement(Map
                .of(FINDER_TYPE, "ByValueKey",
                        "keyValueType", "String",
                        "keyValueString", key));
        flutterElement.setParent(driver);
        return flutterElement;
    }

    @Override
    public FlutterElement byValueKey(int key) {
        FlutterElement flutterElement = new FlutterElement(Map
                .of(FINDER_TYPE, "ByValueKey",
                        "keyValueType", "int",
                        "keyValueString", key));
        flutterElement.setParent(driver);
        return flutterElement;
    }

    @Override
    public FlutterElement byType(String type) {
        FlutterElement flutterElement = new FlutterElement(Map.of(
                FINDER_TYPE, "ByType",
                "type", type
        ));
        flutterElement.setParent(driver);
        return flutterElement;
    }

    @Override
    public FlutterElement byToolTip(String toolTipText) {
        FlutterElement flutterElement = new FlutterElement(Map.of(
                FINDER_TYPE, "ByTooltipMessage",
                "text", toolTipText
        ));
        flutterElement.setParent(driver);
        return flutterElement;
    }

    @Override
    public FlutterElement byText(String input) {
        FlutterElement flutterElement = new FlutterElement(Map.of(
                FINDER_TYPE, "ByText",
                "text", input
        ));
        flutterElement.setParent(driver);
        return flutterElement;
    }

    @Override
    public FlutterElement byAncestor(FlutterElement of, FlutterElement matching,
                                     boolean matchRoot, boolean firstMatchOnly) {
        Map<String, Object> matchIdentifier = new HashMap<>(Map.of(
                FINDER_TYPE, "Ancestor",
                "matchRoot", matchRoot,
                "firstMatchOnly", firstMatchOnly
        ));
        matchIdentifier.put("of", of.getRawMap());
        matchIdentifier.put("matching", matching.getRawMap());
        FlutterElement flutterElement = new FlutterElement(matchIdentifier);
        flutterElement.setParent(driver);
        return flutterElement;
    }

    @Override
    public FlutterElement byDescendant(FlutterElement of, FlutterElement matching,
                                       boolean matchRoot, boolean firstMatchOnly) {
        Map<String, Object> matchIdentifier = new HashMap<>(Map.of(
                FINDER_TYPE, "Descendant",
                "matchRoot", matchRoot,
                "firstMatchOnly", firstMatchOnly
        ));
        matchIdentifier.put("of", of.getRawMap());
        matchIdentifier.put("matching", matching.getRawMap());
        FlutterElement flutterElement = new FlutterElement(matchIdentifier);
        flutterElement.setParent(driver);
        return flutterElement;
    }

    @Override
    public FlutterElement bySemanticsLabel(String label) {
        FlutterElement flutterElement = new FlutterElement(Map.of(
                FINDER_TYPE, "BySemanticsLabel",
                "isRegExp", false,
                "label", label
        ));
        flutterElement.setParent(driver);
        return flutterElement;
    }

    @Override
    public FlutterElement bySemanticsLabel(Pattern label) {
        FlutterElement flutterElement = new FlutterElement(Map.of(
                FINDER_TYPE, "BySemanticsLabel",
                "isRegExp", true,
                "label", label.toString()
        ));
        flutterElement.setParent(driver);
        return flutterElement;
    }

    @Override
    public FlutterElement pageBack() {
        return new FlutterElement(Map.of(FINDER_TYPE, "PageBack"));
    }
}