# 上游更新维护说明

本文档用于记录当前仓库中“Claude 风格聊天页改造”相关改动的边界，以及后续如何安全地同步原项目更新。

## 目标

维护原则只有一句话：

- **尽量让上游继续负责业务逻辑与新功能**
- **本仓库只额外维护聊天页 UI、主题与图标风格层**

这样做的好处是：以后同步上游时，冲突会尽量集中在少数几个界面文件中，而不会蔓延到数据层、服务层和模型层。

## 当前改动边界

### 一、聊天页 UI 主改动文件

这些文件是 Claude 风格改造的核心区域，后续同步上游时应重点检查：

- [`app/src/main/java/me/rerere/rikkahub/ui/pages/chat/ChatPage.kt`](../app/src/main/java/me/rerere/rikkahub/ui/pages/chat/ChatPage.kt)
- [`app/src/main/java/me/rerere/rikkahub/ui/components/ai/ChatInput.kt`](../app/src/main/java/me/rerere/rikkahub/ui/components/ai/ChatInput.kt)
- [`app/src/main/java/me/rerere/rikkahub/ui/components/message/ChatMessage.kt`](../app/src/main/java/me/rerere/rikkahub/ui/components/message/ChatMessage.kt)
- [`app/src/main/java/me/rerere/rikkahub/ui/components/message/ChatMessageActions.kt`](../app/src/main/java/me/rerere/rikkahub/ui/components/message/ChatMessageActions.kt)
- [`app/src/main/java/me/rerere/rikkahub/ui/components/message/ChatMessageReasoning.kt`](../app/src/main/java/me/rerere/rikkahub/ui/components/message/ChatMessageReasoning.kt)
- [`app/src/main/java/me/rerere/rikkahub/ui/components/message/ChatMessageTools.kt`](../app/src/main/java/me/rerere/rikkahub/ui/components/message/ChatMessageTools.kt)
- [`app/src/main/java/me/rerere/rikkahub/ui/components/ui/ChainOfThought.kt`](../app/src/main/java/me/rerere/rikkahub/ui/components/ui/ChainOfThought.kt)
- [`app/src/main/java/me/rerere/rikkahub/ui/components/ui/RabbitLoading.kt`](../app/src/main/java/me/rerere/rikkahub/ui/components/ui/RabbitLoading.kt)
- [`app/src/main/java/me/rerere/rikkahub/ui/pages/chat/Export.kt`](../app/src/main/java/me/rerere/rikkahub/ui/pages/chat/Export.kt)
- [`app/src/main/java/me/rerere/rikkahub/ui/pages/chat/ChatDrawer.kt`](../app/src/main/java/me/rerere/rikkahub/ui/pages/chat/ChatDrawer.kt)
- [`app/src/main/java/me/rerere/rikkahub/ui/pages/chat/ConversationList.kt`](../app/src/main/java/me/rerere/rikkahub/ui/pages/chat/ConversationList.kt)
- [`app/src/main/java/me/rerere/rikkahub/ui/pages/chat/ChatList.kt`](../app/src/main/java/me/rerere/rikkahub/ui/pages/chat/ChatList.kt)

### 二、主题与图标层文件

这些文件尽量作为“可插拔风格层”维护：

- [`app/src/main/java/me/rerere/rikkahub/ui/theme/ClaudeIcons.kt`](../app/src/main/java/me/rerere/rikkahub/ui/theme/ClaudeIcons.kt)
- [`app/src/main/java/me/rerere/rikkahub/ui/theme/presets/ClaudeTheme.kt`](../app/src/main/java/me/rerere/rikkahub/ui/theme/presets/ClaudeTheme.kt)
- [`app/src/main/java/me/rerere/rikkahub/ui/theme/PresetTheme.kt`](../app/src/main/java/me/rerere/rikkahub/ui/theme/PresetTheme.kt)
- [`app/src/main/java/me/rerere/rikkahub/ui/theme/Theme.kt`](../app/src/main/java/me/rerere/rikkahub/ui/theme/Theme.kt)

相关素材目录：

- [`icon/`](../icon)
- [`anim/`](../anim)

### 三、资源与文案文件

这些属于低风险样式/文案跟随项：

- [`app/src/main/res/values/strings.xml`](../app/src/main/res/values/strings.xml)
- [`app/src/main/res/values-zh/strings.xml`](../app/src/main/res/values-zh/strings.xml)
- [`app/src/main/res/values-zh-rTW/strings.xml`](../app/src/main/res/values-zh-rTW/strings.xml)
- [`app/src/main/res/values-ja/strings.xml`](../app/src/main/res/values-ja/strings.xml)
- [`app/src/main/res/values-ko-rKR/strings.xml`](../app/src/main/res/values-ko-rKR/strings.xml)
- [`app/src/main/res/values-ru/strings.xml`](../app/src/main/res/values-ru/strings.xml)

### 四、构建与环境相关改动

以下文件属于“为了本地构建和依赖下载更稳定而修改”的工程级配置。同步上游时，这些文件要单独判断是否继续保留：

- [`app/build.gradle.kts`](../app/build.gradle.kts)
- [`settings.gradle.kts`](../settings.gradle.kts)
- [`gradle.properties`](../gradle.properties)
- [`gradle/wrapper/gradle-wrapper.properties`](../gradle/wrapper/gradle-wrapper.properties)

## 后续同步上游时的推荐做法

## 1. 分支策略

建议至少保留两个长期分支：

- `main`：尽量贴近上游
- `claude-ui`：维护你的 Claude 风格版本

推荐流程：

1. 把上游最新代码同步到 `main`
2. 切回 `claude-ui`
3. 将 `main` 合并或 rebase 到 `claude-ui`
4. 只处理聊天页 UI 和主题层冲突
5. 重新编译验证

## 2. 合并策略

### 适合大多数情况：使用 merge

优点：

- 直观
- 不容易因为历史重写导致混乱
- 比较适合长期自己维护

### 想保持历史整洁：使用 rebase

优点：

- 提交历史更干净
- 更容易看出哪些是你的 Claude UI 改动

代价：

- 冲突处理时要更小心
- 如果你不熟悉 Git，容易改乱提交历史

如果只是自己本地维护，优先推荐 **merge 上游**。

## 3. 每次更新时优先检查哪些地方

同步上游后，优先检查这几类变化：

### A. 聊天页入口是否被上游改动

重点检查：

- [`ChatPage.kt`](../app/src/main/java/me/rerere/rikkahub/ui/pages/chat/ChatPage.kt)

看这些内容有没有变化：

- 顶栏结构
- 底部输入区挂载方式
- 消息列表容器结构
- 菜单与弹窗入口

### B. 输入区接口是否变化

重点检查：

- [`ChatInput.kt`](../app/src/main/java/me/rerere/rikkahub/ui/components/ai/ChatInput.kt)

看这些内容有没有变化：

- 发送回调参数
- 搜索/推理开关状态
- 附件、语音、工具入口
- placeholder、输入框状态管理

### C. 消息渲染入口是否变化

重点检查：

- [`ChatMessage.kt`](../app/src/main/java/me/rerere/rikkahub/ui/components/message/ChatMessage.kt)
- [`ChatMessageActions.kt`](../app/src/main/java/me/rerere/rikkahub/ui/components/message/ChatMessageActions.kt)
- [`ChatMessageReasoning.kt`](../app/src/main/java/me/rerere/rikkahub/ui/components/message/ChatMessageReasoning.kt)
- [`ChatMessageTools.kt`](../app/src/main/java/me/rerere/rikkahub/ui/components/message/ChatMessageTools.kt)

看这些内容有没有变化：

- 新消息类型
- 工具调用展示方式
- reasoning / thinking 数据结构
- 操作按钮行为映射

## 4. 哪些层尽量不要动

为了降低后续维护成本，以下层如果不是必须，尽量不要继续深改：

- [`app/src/main/java/me/rerere/rikkahub/service/ChatService.kt`](../app/src/main/java/me/rerere/rikkahub/service/ChatService.kt)
- [`app/src/main/java/me/rerere/rikkahub/service/ConversationSession.kt`](../app/src/main/java/me/rerere/rikkahub/service/ConversationSession.kt)
- [`app/src/main/java/me/rerere/rikkahub/data/model/Conversation.kt`](../app/src/main/java/me/rerere/rikkahub/data/model/Conversation.kt)
- [`app/src/main/java/me/rerere/rikkahub/data/model/Assistant.kt`](../app/src/main/java/me/rerere/rikkahub/data/model/Assistant.kt)
- [`ai/`](../ai)

原因：

- 这些文件更容易跟上游功能更新发生实质性冲突
- 一旦你在这里做大量定制，之后同步上游会明显变难

## 5. 推荐保留的“风格隔离”原则

后续如果继续改 UI，尽量遵守下面几条：

### 原则一：颜色走主题，不写死

优先把颜色沉淀到：

- [`ClaudeTheme.kt`](../app/src/main/java/me/rerere/rikkahub/ui/theme/presets/ClaudeTheme.kt)
- [`Theme.kt`](../app/src/main/java/me/rerere/rikkahub/ui/theme/Theme.kt)

避免在 [`ChatPage.kt`](../app/src/main/java/me/rerere/rikkahub/ui/pages/chat/ChatPage.kt) 或 [`ChatMessage.kt`](../app/src/main/java/me/rerere/rikkahub/ui/components/message/ChatMessage.kt) 里继续新增大量硬编码颜色。

### 原则二：图标统一走 Claude 图标层

优先复用：

- [`ClaudeIcons.kt`](../app/src/main/java/me/rerere/rikkahub/ui/theme/ClaudeIcons.kt)

不要把 SVG path 零散写到各个页面文件里。

### 原则三：业务逻辑与样式逻辑分开

例如：

- “按钮点了做什么”尽量沿用上游现有回调
- “按钮长什么样”放在聊天页组件内部维护

这样即使上游更新功能，你通常只需要重新接一下参数，不需要重写业务逻辑。

## 实际更新流程范例

下面是一个建议流程：

1. 先查看当前改动
2. 提交你自己的 UI 改动
3. 拉取上游更新
4. 合并到你的 Claude UI 分支
5. 解决冲突
6. 编译验证

常用命令示例：

```bash
git status
git add .
git commit -m "feat: claude style chat ui"
git checkout main
git pull upstream main
git checkout claude-ui
git merge main
```

如果你更偏好 rebase，则流程改成：

```bash
git checkout main
git pull upstream main
git checkout claude-ui
git rebase main
```

## 冲突处理优先级

如果同步上游时发生冲突，推荐按这个顺序处理：

1. 先保留上游业务逻辑变化
2. 再恢复你的 Claude 样式层
3. 最后再微调视觉细节

也就是说，**先确保能跑，再恢复好看**。

## 本仓库建议补做的事情

后续维护上，我已经把最值得做的一项文档化工作落地到当前文件。

接下来你自己继续维护时，建议再补两件事：

1. 提交一次干净的 Git commit，把当前 Claude 化成果固定下来
2. 编译验证一次关键聊天页改动，确认没有遗漏的引用或资源问题

## 结论

这个仓库现在已经可以作为“基于上游持续更新、但聊天页使用 Claude 风格”的长期维护版本来管理。

后续只要记住一句话：

- **上游负责功能演进**
- **你这边负责聊天页 UI、主题、图标层的持续覆盖**

这样维护成本最低，也最容易继续吃到原项目的新版本能力。