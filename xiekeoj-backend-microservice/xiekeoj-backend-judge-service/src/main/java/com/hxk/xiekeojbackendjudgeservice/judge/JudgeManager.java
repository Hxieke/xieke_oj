package com.hxk.xiekeojbackendjudgeservice.judge;

import com.hxk.xiekeojbackendjudgeservice.judge.strategy.DefaultJudgeStrategy;
import com.hxk.xiekeojbackendjudgeservice.judge.strategy.JavaLanguageJudgeStrategy;
import com.hxk.xiekeojbackendjudgeservice.judge.strategy.JudgeContext;
import com.hxk.xiekeojbackendjudgeservice.judge.strategy.JudgeStrategy;
import com.hxk.xiekeojbackendmodel.model.codesandbox.JudgeInfo;
import com.hxk.xiekeojbackendmodel.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}
